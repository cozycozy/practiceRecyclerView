package apps.test.marketableskill.biz.recyclerview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        d_file_name.text = intent.getStringExtra(ExtraImageFile.NAME.name)
        d_file_storage.text = intent.getStringExtra(ExtraImageFile.AMOUNT.name)
        d_file_size.text = intent.getStringExtra(ExtraImageFile.HEIGHT.name) +
                " / " + intent.getStringExtra(ExtraImageFile.WIDTH.name)
        d_file_date.text = intent.getStringExtra(ExtraImageFile.DATE.name)

    }

    override fun onOptionsItemSelected(item: MenuItem) =

        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this,ListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

}

