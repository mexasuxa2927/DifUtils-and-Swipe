
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.difssss.Interfacesss.MyItemInterface
import com.example.difssss.Models.UserModel
import com.example.difssss.R
import kotlinx.android.synthetic.main.custom_item.view.*


class AdapterRec(var arrayList : ArrayList<UserModel>) :ListAdapter<UserModel,AdapterRec.MyViewHolder>(MyDifUtil()),MyItemInterface {

    inner class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun onBinding(userModel : UserModel){

            itemView.Tv1.text = userModel.username


        }
    }



    class  MyDifUtil :DiffUtil.ItemCallback<UserModel>(){
        override fun areItemsTheSame(oldItem : UserModel, newItem : UserModel) : Boolean {
            return oldItem.username.equals(newItem.username)
        }

        override fun areContentsTheSame(oldItem : UserModel, newItem : UserModel) : Boolean {
            return true
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item,parent,false))
    }

    override fun onBindViewHolder(holder : MyViewHolder, position : Int) {
        holder.onBinding(getItem(position))

    }

    override fun onMove(fromPosition : Int, toPosition : Int) {
    }

    override fun onRemove(position : Int) {
        arrayList.removeAt(position)
        notifyItemRemoved(position)
    }


}