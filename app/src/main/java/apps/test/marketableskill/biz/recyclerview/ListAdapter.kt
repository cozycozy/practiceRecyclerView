package apps.test.marketableskill.biz.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class ListAdapter(private val mParentActivity : ListActivity,
                       private val mValues: ArrayList<Imagefile>) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        //レイアウトの設定(inflate)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)

        //Holderの生成
        val holder = ListViewHolder(view)

        //タップした時のリスナーを設定
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            onListClicked(view, position)
        }

        return holder

    }

    open fun onListClicked(view: View?, position: Int) {

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val item = mValues[position]
        holder.mfileDrawable.setImageDrawable(item.imageDrawable)
        holder.mfileName.text = item.fileName
        holder.mfileSize.text = item.fileAmaount
        holder.mfileDate.text = item.fileDate

    }

    override fun getItemCount(): Int {

        return mValues.size

    }
}