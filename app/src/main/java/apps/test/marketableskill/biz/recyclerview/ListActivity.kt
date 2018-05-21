package apps.test.marketableskill.biz.recyclerview

import android.content.ContentResolver
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

import kotlinx.android.synthetic.main.content_list.*

class ListActivity : AppCompatActivity() {

    private var mDataList : ArrayList<Imagefile> = ArrayList<Imagefile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        // データ作成
        getImagefiles()

        // Adapter作成
        val adapter = ListAdapter(this,mDataList)

        // RecyclerViewにAdapterとLayoutManagerの設定
        ListRecyclerView.adapter = adapter
        ListRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    private fun getImagefiles() {

        val cr : ContentResolver = contentResolver

        val projection : Array<String> = arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.HEIGHT,
                MediaStore.Images.Media.WIDTH,
                MediaStore.Images.Media.DATE_MODIFIED)


        val cursor = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection,null,null,null)

        val idIndex = cursor.getColumnIndex(MediaStore.Images.Media._ID)
        var pathIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
        val nameIndex = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)
        val sizeIndex = cursor.getColumnIndex(MediaStore.Images.Media.SIZE)
        val heightIndex = cursor.getColumnIndex(MediaStore.Images.Media.HEIGHT)
        val widthIndex = cursor.getColumnIndex(MediaStore.Images.Media.WIDTH)
        val modify_date_Index = cursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED)

        cursor.moveToFirst()

        while (!cursor.isAfterLast){

            mDataList.add(Imagefile(
                    MediaStore.Images.Thumbnails.getThumbnail(cr,
                            cursor.getLong(idIndex),
                            MediaStore.Images.Thumbnails.MICRO_KIND,
                            null),
                    cursor.getString(nameIndex),
                    cursor.getString(sizeIndex),
                    cursor.getString(heightIndex),
                    cursor.getString(widthIndex),
                    cursor.getString(modify_date_Index)
            ))
            cursor.moveToNext()
        }

    }

    override fun onResume() {
        super.onResume()

    }

}
