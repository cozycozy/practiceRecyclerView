package apps.test.marketableskill.biz.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_list.view.*

class ListViewHolder(mView : View) : RecyclerView.ViewHolder(mView) {

    val mfileBitmap = mView.imageView
    val mfileName = mView.fileName
    val mfileSize = mView.fileSize
    val mfileDate = mView.fileDate

}
