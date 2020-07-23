
import com.google.gson.annotations.SerializedName
class CitiesResponse : ArrayList<CitiesResponse.Item>(){
    data class Item(
        @SerializedName("id")
        val id: Int,
        @SerializedName("latitude")
        val latitude: String,
        @SerializedName("longitude")
        val longitude: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("population")
        val population: Int,
        @SerializedName("region")
        val region: String


    )
}