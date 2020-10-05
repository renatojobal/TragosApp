package com.renatojobal.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.renatojobal.tragosapp.AppDatabase
import com.renatojobal.tragosapp.R
import com.renatojobal.tragosapp.data.DataSourceImpl
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.RepoImpl
import com.renatojobal.tragosapp.domain.TragosDao
import com.renatojobal.tragosapp.ui.viewmodel.MainViewModel
import com.renatojobal.tragosapp.vo.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favoritos.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [FavoritosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FavoritosFragment : Fragment() {


    private val viewModel by viewModels<MainViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTragosFavoritos.layoutManager = LinearLayoutManager(requireContext())
        rvTragosFavoritos.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))


        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    progressBarFavoritos.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBarFavoritos.visibility = View.GONE
                    rvTragosFavoritos.adapter = MainAdapter(requireContext(), result.data, object : MainAdapter.OnTragoClickListener{
                        override fun onTragoClick(drink: Drink, position: Int) {
                            // Dlete trago
                            viewModel.deleteTrago(drink)
                            rvTragosFavoritos.adapter?.notifyItemRemoved(position)
                            rvTragosFavoritos.adapter?.notifyDataSetChanged()
                        }

                    })
                }
                is Resource.Failure -> {
                    progressBarFavoritos.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrió un error al traer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

}