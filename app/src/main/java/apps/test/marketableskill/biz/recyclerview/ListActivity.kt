package apps.test.marketableskill.biz.recyclerview

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*

import kotlinx.android.synthetic.main.content_list.*

class ListActivity : AppCompatActivity() {

    private var mDataList : ArrayList<Imagefile> = ArrayList<Imagefile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        // データ作成
        makeTestData()

        // Adapter作成
        val adapter = object : ListAdapter(this,mDataList) {
            //リスナー(タップされた時)の処理
            override fun onListClicked(view: View?, position: Int) {
                val intent = Intent(view!!.context, DetailActivity::class.java).apply {
                    putExtra(ExtraImageFile.NAME.name, mDataList[position].fileName)
                    putExtra(ExtraImageFile.AMOUNT.name, mDataList[position].fileAmaount)
                    putExtra(ExtraImageFile.HEIGHT.name, mDataList[position].fileHeight)
                    putExtra(ExtraImageFile.WIDTH.name, mDataList[position].fileWidth)
                    putExtra(ExtraImageFile.DATE.name, mDataList[position].fileDate)
                }
                view.context.startActivity(intent)
            }
        }

        // RecyclerViewにAdapterとLayoutManagerの設定
        ListRecyclerView.adapter = adapter
        ListRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    private fun makeTestData() {

        //20個のテストデータ作成
        for (i in 1..20){
            mDataList.add(Imagefile(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_launcher_background, null)!!,
                    "ファイル_" + i.toString(),
                    ""+(i*100).toString(),
                    ""+(i*2).toString(),
                    ""+(i*3).toString(),
                    "2018/5/" + i.toString()))
        }

    }

}
