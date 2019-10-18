package com.mac.macjetpackdemo.ui.type

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListAdapter
import android.widget.TextView
import com.mac.macjetpackdemo.R
import com.mac.macjetpackdemo.data.model.TypeResult

class ExListAdapter(private val data: List<TypeResult.TypeList>) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return data[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val holder: GroupHolder
        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_type, parent, false)
            holder = GroupHolder(itemView)
            itemView.tag = holder
        } else {
            itemView = convertView
            holder = itemView.tag as GroupHolder
        }
        val bean = data[groupPosition]
        bean?.run {
            holder.mTypeTv.text = name
        }
        return itemView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return data[groupPosition].list?.size!!
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return data[groupPosition].list!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int, childPosition: Int, isLastChild: Boolean,
        convertView: View?, parent: ViewGroup?
    ): View {
        val holder: ChildHolder
        val childView: View
        if (convertView == null) {
            childView = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
            holder = ChildHolder(childView)
            childView.tag = holder
        } else {
            childView = convertView
            holder = childView.tag as ChildHolder
        }
        val childBean = data[groupPosition].list!![childPosition]
        childBean?.run {
            holder.mChildTv.text = name
        }
        return childView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return data.size
    }

    inner class GroupHolder(itemView: View) {
        val mTypeTv = itemView.findViewById<TextView>(R.id.item_type_tv)
    }

    inner class ChildHolder(childView: View) {
        val mChildTv = childView.findViewById<TextView>(R.id.item_child_tv)
    }
}