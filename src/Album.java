import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    //private ArrayList<Song> songs;
    private  SongList songs;

public Album(String name, String artist){
    this.name = name;
    this.artist = artist;
    this.songs = new SongList();

    }

    public boolean addSong(String title, double duration){//we are going to call .add() from inner class
       return this.songs.add(new Song(title, duration));
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(trackNumber);//from inner class method
            if (checkedSong != null){
                playList.add(checkedSong);
                return true;
            }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkSong = songs.findSong(title);//from inner class method
        if (checkSong != null){
            playList.add(checkSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
             return false;
    }


    public class SongList{    //our inner class
            private ArrayList<Song> songs;

            public SongList(){
                this.songs = new ArrayList<Song>();
            }


            public boolean add(Song song){
                if(songs.contains(song)){
                    return false;
                }
                this.songs.add(song);
                    return true;
                }


        private Song findSong(String title){
            //checking for not duplicating songs
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }


        private Song findSong(int trackNumber){
                int index = trackNumber -1;
                    if((index >= 0) && (index < songs.size())){
                        return songs.get(index);
              }
            return null;
        }
    }
}
