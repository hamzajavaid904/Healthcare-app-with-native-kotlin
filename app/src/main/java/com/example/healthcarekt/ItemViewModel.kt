package com.example.healthcarekt

data class ItemViewModel(var image : Int,var description : String,var date :String, var time:String)
data class ItemViewModel2(var image2 : Int,var Docname : String,var specaility : String,var rating : String , var location : String)
data class ItemViewModel3(var day : String,var date :String)
data class ItemViewModelpharm(var imagemed : Int , var Medicinename : String, var Medicinequantity : String, var Medicineprice : String)
data class ItemViewModelPharmsale(var imagemedS : Int , var MedicinenameS : String, var MedicinequantityS : String, var MedicinepriceS : String , var Medicinepricesale: String)