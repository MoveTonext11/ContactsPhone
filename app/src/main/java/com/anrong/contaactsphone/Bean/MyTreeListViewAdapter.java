package com.anrong.contaactsphone.Bean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Utils.SqliteUtils;
import com.anrong.contaactsphone.tree.Node;
import com.anrong.contaactsphone.tree.TreeListViewAdapter;

import java.util.List;

public class MyTreeListViewAdapter<T> extends TreeListViewAdapter<T> {
	public MyTreeListViewAdapter(ListView mTree, Context context, List<T> datas, int defaultExpandLevel,boolean isHide)
			throws IllegalArgumentException, IllegalAccessException {

		super(mTree, context, datas, defaultExpandLevel,isHide);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public View getConvertView(final Node node, int position, View convertView,
                               ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_items, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView.findViewById(R.id.id_treenode_name);
			viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.id_treeNode_check);
			viewHolder.start = (ImageView) convertView.findViewById(R.id.id_treenode_start);

			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if (node.getIcon() == -1) {
			viewHolder.icon.setVisibility(View.INVISIBLE);
            viewHolder.start.setVisibility(View.VISIBLE);
		} else {
			viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.start.setVisibility(View.INVISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		}

		if(node.isHideChecked()){
			viewHolder.checkBox.setVisibility(View.GONE);
		}else{
			viewHolder.checkBox.setVisibility(View.VISIBLE);
			setCheckBoxBg(viewHolder.checkBox,node.isChecked());
		}
		viewHolder.label.setText(node.getName());
		viewHolder.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteUtils sql = new SqliteUtils(mContext);
                sql.getinstance();
                //添加联系人  插入数据库
                long addcymessage = sql.addcymessage(node.getName(), node.getIcon(), "34123");
                if (String.valueOf(addcymessage).equals("-1")){
					Toast.makeText(mContext, "常用联系已存在", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(mContext, "常用联系人添加成功", Toast.LENGTH_SHORT).show();
				}
            }
        });

		return convertView;
	}
	private final class ViewHolder {
		ImageView icon;
		TextView label;
		CheckBox checkBox;
		ImageView start;
	}
	
	/**
	 * checkbox是否显示
	 * @param cb
	 * @param isChecked
	 */
	private void setCheckBoxBg(CheckBox cb,boolean isChecked){
		if(isChecked){
			cb.setBackgroundResource(R.drawable.check_box_bg_check);
		}else{
			cb.setBackgroundResource(R.drawable.check_box_bg);
		}
	}
}
