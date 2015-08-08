package com.example.adapter;

import java.util.List;

import com.example.day07_29.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter{
	Context context;
	List<String> list;
	
	final int VIEW_TYPE = 3;
	final int TYPE_1 = 0;
	final int TYPE_2 = 1;
	final int TYPE_3 = 2;
	public MyBaseAdapter(Context context, List<String> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		int p = position%6;
		if(p==0){
			return TYPE_1;
		}else if(p<3){
			return TYPE_2;
			
		}else if(p<6){
			return TYPE_3;
		}else
			return TYPE_1;

	}
	

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 3;
	}



@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	ViewHolder1 holder1 = null;
	ViewHolder2 holder2 = null;
	ViewHolder3 holder3 = null;
	int type = getItemViewType(position);

	//无convertView，需要new出各个控件
	if(convertView == null)
	{ 

		//按当前所需的样式，确定new的布局
		switch(type)
		{
		case TYPE_1:
			convertView = LayoutInflater.from(context).inflate(R.layout.list_1, null);
			holder1 = new ViewHolder1();
			holder1.textView = (TextView)convertView.findViewById(R.id.textView1);
			convertView.setTag(holder1);
			break;
		case TYPE_2:
			convertView = LayoutInflater.from(context).inflate(R.layout.list_2, null);
			holder2 = new ViewHolder2();
			holder2.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
			convertView.setTag(holder2);
			break;
		case TYPE_3:
			convertView = LayoutInflater.from(context).inflate(R.layout.list_3, null);
			holder3 = new ViewHolder3();
			holder3.textView = (TextView)convertView.findViewById(R.id.textView_3);
			holder3.imageView = (ImageView)convertView.findViewById(R.id.imageView_3);
			convertView.setTag(holder3);
			break;
		}
	}else{
		//有convertView，按样式，取得不用的布局
		switch(type)
		{
		case TYPE_1:
			holder1 = (ViewHolder1) convertView.getTag();
			break;
		case TYPE_2:
			holder2 = (ViewHolder2) convertView.getTag();
			break;
		case TYPE_3:
			holder3 = (ViewHolder3) convertView.getTag();
			break;
		}
	}

	//设置资源
	switch(type)
	{
	case TYPE_1:
		holder1.textView.setText(Integer.toString(position));
		break;
	case TYPE_2:
		holder2.imageView.setBackgroundResource(R.drawable.ic_launcher);
		break;
	case TYPE_3:
		holder3.textView.setText(Integer.toString(position));
		holder3.imageView.setBackgroundResource(R.drawable.ic_launcher);
		break;
	}

	return convertView;

}
class ViewHolder1{
	TextView textView;
}
class ViewHolder2{
	ImageView imageView;
}
class ViewHolder3{
	TextView textView;
	ImageView imageView;
}
}
