package com.cmft.macjetpackdemo.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.net.Status
import com.cmft.macjetpackdemo.util.InjectUtil

class DetailActivity : AppCompatActivity() {

    lateinit var viewModel: DetailModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProviders.of(this, InjectUtil.getDetailModelFactory())
            .get(DetailModel::class.java)

        val liveData = viewModel.getSearchDetail("肉夹馍")

        liveData.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                it.data?.run {
                    Toast.makeText(this@DetailActivity, result.num, Toast.LENGTH_SHORT).show()
                }
            } else if (it.status == Status.ERROR) {
                Toast.makeText(this@DetailActivity, it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
