package com.example.aka.items

data class AccordionItem(
    val name: String,
    val description: String,
    var isExpanded: Boolean = false
)