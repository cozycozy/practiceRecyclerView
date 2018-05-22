package apps.test.marketableskill.biz.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list.view.*

class ListViewHolder(mView : View) : RecyclerView.ViewHolder(mView) {

    val mfileDrawable : ImageView = mView.imageView
    val mfileName : TextView = mView.fileName
    val mfileSize : TextView = mView.fileSize
    val mfileDate : TextView = mView.fileDate

}
