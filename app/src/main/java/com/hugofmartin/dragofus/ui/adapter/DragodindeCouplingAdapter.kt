import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.ui.viewholder.DragodindeCouplingViewHolder

class DragodindeCouplingAdapter(
    private val context: Context,
    private var dataSource: List<Dragodinde>
) : BaseAdapter() {


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View
        val dragodindeViewHolder: DragodindeCouplingViewHolder

        if (p1 == null) {
            view = LayoutInflater.from(context).inflate(R.layout.coupling_dragodinde_view_holder, p2, false)
            dragodindeViewHolder = DragodindeCouplingViewHolder(view)
            view.tag = dragodindeViewHolder
        } else {
            view = p1
            dragodindeViewHolder = view.tag as DragodindeCouplingViewHolder
        }


        dragodindeViewHolder.name.text = dataSource[p0].name
        dragodindeViewHolder.image.setImageResource(dataSource[p0].race.getImage())
        dragodindeViewHolder.couplingNb.text = dataSource[p0].nbCoupling.toString()
        return view
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    fun submitList(list: List<Dragodinde>) {
        this.dataSource = list
    }
}