package com.example.aka

data class AccordionItem(
    val name: String,
    val description: String,
    var isExpanded: Boolean = false
)