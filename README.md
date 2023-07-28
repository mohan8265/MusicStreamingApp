# MusicStreamingApi




## Framework and language used 
* Spring Boot
* Java
---
## Data flow
1. controllers
    * AdminController
    * PlaylistController
    * SongController
    * UserController

2. dto
    * SignInInput

3. models
    * Admin
    * AuthenticationToken 
    * Playlist
    * Song
    * User

4. repositories
    * IAdminRepo
    * IAuthtokenRepo
    * IPlaylistRepo
    * ISongRepo
    * IUserRepo

5. services
    * AdminService
    * AuthTokenService
    * PasswordEncrypter
    * PlaylistService
    * SongService
    * UserService


6. MusicStreamingApiApplication (main class)

---

## Data Structure Used
* MySQL
* AWS
---

```Its a Music Streaming Api Project in this I have created models like Admin, AuthenticationToken, Playlist, Song and User. here first Admin have to add there information for doing operations after providing correct information. now admin has acces for do CRUD(Create, Read, Update, Delete) operations on songs. User have to Register themselves by providing correct information. and successfully login they are eleigible to do CRUD operations on playlist.```
