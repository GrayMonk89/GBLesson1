package ru.gb.gblesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.gb.gblesson1.databinding.ActivityMainBinding
import ru.gb.gblesson1.utils.DEFAULT_VALUE_ONE
import ru.gb.gblesson1.utils.DEFAULT_VALUE_TWO
import ru.gb.gblesson1.utils.DEFAULT_VALUE_ZERO

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        initClickListener()
    }

    private fun initClickListener() {
        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(DEFAULT_VALUE_ZERO)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(DEFAULT_VALUE_ONE)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(DEFAULT_VALUE_TWO)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                DEFAULT_VALUE_ZERO -> tvText1.text = counter
                DEFAULT_VALUE_ONE -> tvText2.text = counter
                DEFAULT_VALUE_TWO -> tvText3.text = counter
            }
        }
    }
}
