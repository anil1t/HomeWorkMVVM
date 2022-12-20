# HomeWorkMVVM
1.First insert username and password in login screen
2.once user add login details then user will click on login button
3.then after user will get response from login api like {
Base URL is :http://private-222d3-homework5.apiary-mock.com/api/login
Request param :
{
"username": "test",
"password": "tset" }


{
    "errorCode": "00",
    "errorMessage": "Sukses.",
    "data": {
        "userId": "1111",
        "userName": "username",
        "isDeleted": true
    }
}
}
4. after that this data object store in local room database
5.every time login api call and get reponse and store data jsonobject and header X-Acc value store in userdatabase
6. used Mvvm code structure 
7. Mutable Live data, Room Database, View Model, Data and View Binging,hilt-dagger for android-compiler and android
8. lifecycle-livedata,retrofit,coroutines,room.
