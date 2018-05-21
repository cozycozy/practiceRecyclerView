package apps.test.marketableskill.biz.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ListAdapter(private val mParentActivity : ListActivity,
                  private val mValues: ArrayList<Imagefile>) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list,parent,false)

        val holder = ListViewHolder(view)

        return holder

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val item = mValues[position]
        holder.mfileBitmap.setImageBitmap(item.imageBitmap)
        holder.mfileName.text = item.fileName
        holder.mfileSize.text = item.fileAmaount
        holder.mfileDate.text = item.fileDate

    }

    override fun getItemCount(): Int {

        return mValues.size

    }
}