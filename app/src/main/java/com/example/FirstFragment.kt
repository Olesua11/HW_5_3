import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import com.example.hw5.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(CounterViewModel::class.java)

        button.setOnClickListener {
            viewModel.updateCounter()
            updateTextView()
        }

        updateTextView()
    }

    private fun updateTextView() {
        textView.text = viewModel.getCounter().toString()
        if (viewModel.getCounter() == 0) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}
