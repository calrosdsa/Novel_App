package com.example.domain.util



sealed class OrderNovel{
    object Added:OrderNovel()
    object Updated:OrderNovel()
}

sealed class NovelOrder(){
//    sealed class NovelOrder(val orderType:OrderType){
        //class Added(orderType: OrderType): NovelOrder(orderType)
    object Added: NovelOrder()
    object Updated: NovelOrder()


    //fun copy(orderType: OrderType): NovelOrder {
    //    return when(this) {
    //        is Added -> Added(orderType)
      //      is Updated -> Updated(orderType)
  //      }
  //  }

    fun compare(novelOrder: NovelOrder): Boolean{
        return when(this) {
            is Updated -> novelOrder == this
            is Added ->  novelOrder === this
        }
    }
}


sealed class NovelOption(){
    class All: NovelOption()
    class Updated: NovelOption()
    class Favorites: NovelOption()
    class Completed: NovelOption()
}


sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()

}