package com.example.aka.items


sealed class CharlistItem {
    data class Header(val title: String) : CharlistItem()
    data class TableItem(val charName: String, val value: String, val modifier: String) : CharlistItem()
    data class Skill(val name: String, val value: String) : CharlistItem()
}