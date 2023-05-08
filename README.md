---------------------------
Better Call Saul
---------------------------
This is an Android app that retrieves data from the Better Call Saul API (https://bettercallsaul-api.onrender.com/) and caches it in Room to allow for offline use.



------------------------------------------
Libraries, Concepts and Technologies Used
------------------------------------------
- Glide (Image Loading)
- Dagger-Hilt (Dependency Injection)
- Kotlin Coroutines and Flows (State Management)
- Room (Local Storage and Caching)
- Retrofit2 and OkHTTP3 (HTTP Request)
- Kotlin Serialization and Jake Wharton's Serialization Library (Json Parsing and Deserialization)
- MVVM Architecture (Except the Domain layer as it would have been overkill to some extent)



-------------------------------------------
Recommendations
-------------------------------------------
- Use of Paging3 library for Pagination
- Use of alternative parameters in the Base URL query
- Use of Coil or any other image loading library
- Inclusion of other details from the .json response
- Inclusion of the Domain Layer
- Using alternative state variables such as MutableStateFlow
- More UI styling and presentation techniques



----------------------------------------------
How To Use
----------------------------------------------
1. Ensure you have Android Studio installed along with other required components such as the Emulator, JDK etc...
2. Download this project using the "Code > Download Zip" or import it in Android Studio using the "File > New > Project From Version Control" option and input the URL found in the "Code > HTTPS" option in GitHub repo...
3. Click "Run" and try launching it again without an internet connection. That's it :)



------------------------------------------------
Notables
------------------------------------------------
- In your DTO and Entity data classes, be careful when using the "firstAppearance" and "lastAppearance" attributes as they seem to be raising an EOF type error which is typical for wrongly formatted or deserialized .json responses.