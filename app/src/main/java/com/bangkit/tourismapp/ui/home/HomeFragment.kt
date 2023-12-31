package com.bangkit.tourismapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.tourismapp.R
import com.bangkit.tourismapp.databinding.FragmentHomeBinding
import com.bangkit.tourismapp.core.ui.TourismAdapter
import com.bangkit.tourismapp.ui.detail.DetailTourismActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

//    @Inject
//    lateinit var factory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (activity != null) {
            val tourismAdapter = TourismAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

//            val factory = ViewModelFactory.getInstance(requireActivity())
//            homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]


            homeViewModel.tourism.observe(viewLifecycleOwner) { tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is com.bangkit.tourismapp.core.data.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is com.bangkit.tourismapp.core.data.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            tourismAdapter.setData(tourism.data)
                        }

                        is com.bangkit.tourismapp.core.data.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                tourism.message ?: getString(R.string.something_wrong)

                        }
                    }
                }
            }
            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}