package ru.gb.gblesson1

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.gblesson1.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }



    private fun initClickListener() {
        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterOneClick()
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterTwoClick()
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterThirdClick()
            }
        }
    }





    override fun setCounterOneText(counter: String) = with(binding) {
        tvText1.text = counter
    }

    override fun setCounterTwoText(counter: String)  = with(binding) {
        tvText2.text = counter
    }

    override fun setCounterThirdText(counter: String)  = with(binding) {
        tvText3.text = counter
    }
}
