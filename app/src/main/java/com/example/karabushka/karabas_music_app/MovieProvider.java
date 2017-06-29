package com.example.karabushka.karabas_music_app;



import com.example.karabushka.karabas_music_app.model.Movie;

import java.util.ArrayList;
/**
 * Created by Karabushka on 25.06.2017.
 */
public class MovieProvider {

    private static final String TAG = MovieProvider.class.getSimpleName();
    public static final int CHILL_OUT_NUMBER = 0;
    public static final int SYNTHWAVE_NUMBER = 1;
    public static final int HIP_HOP_NUMBER = 2;
    public static final int ROCK_NUMBER = 3;
    public static final int[] ALL_CHANNELS= {CHILL_OUT_NUMBER,SYNTHWAVE_NUMBER,
            HIP_HOP_NUMBER,ROCK_NUMBER};
    private static final String PACKAGE_NAME = "com.example.android.sampletvinput";

    private static ArrayList<Movie> mItems = null;
    
    private MovieProvider() {}

    public static ArrayList<Movie> getMovieItems(int channelNumber) {
        if(channelNumber==CHILL_OUT_NUMBER) {
            mItems = null;
            mItems = new ArrayList<Movie>();

            Movie movie1 = new Movie();
            movie1.setId(1);
            movie1.setTitle("Krewella - Parachute ");
            movie1.setStudio("xKito Music");
            movie1.setVideoGenreId(CHILL_OUT_NUMBER);
            movie1.setDescription("You like to draw and would like your art to be featured on an " +
                    "xKito Music Video? Send an email to xkitomusic@gmail.com with your art attached!");
            movie1.setCardImageUrl("http://i1.ytimg.com/vi/gwDoRPcPxtc/maxresdefault.jpg");
            movie1.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video1.mp4");
            mItems.add(movie1);

            Movie movie2 = new Movie();
            movie2.setId(2);
            movie2.setTitle("Lauv - I Like Me Better ");
            movie2.setStudio("xKito Music");
            movie2.setVideoGenreId(CHILL_OUT_NUMBER);
            movie2.setDescription("Everyone that reads this have a great weekend and a good rest of " +
                    "the day. And thx for another great song xkito!!");
            movie2.setCardImageUrl("http://i1.ytimg.com/vi/f7Y8JkHcI3I/maxresdefault.jpg");
            movie2.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video2.mp4");
            mItems.add(movie2);

            Movie movie3 = new Movie();
            movie3.setId(3);
            movie3.setTitle("CloZee X VOLO - Soul Search ");
            movie3.setStudio("xKito Music");
            movie3.setVideoGenreId(CHILL_OUT_NUMBER);
            movie3.setDescription("funnily the artist Guweiz is influenced heavily by an artist called " +
                    "WLOP and this pic is like a mashup of two of WLOP's works, so I don't really blame" +
                    " people for not recognising her at first glance");
            movie3.setCardImageUrl("http://i1.ytimg.com/vi/JL6FJL8TN0U/maxresdefault.jpg");
            movie3.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video3.mp4");
            mItems.add(movie3);
        }
        else if(channelNumber==SYNTHWAVE_NUMBER){
            mItems = null;
            mItems = new ArrayList<Movie>();
            Movie movie1 = new Movie();
            movie1.setId(4);
            movie1.setTitle("Zombie Hyperdrive - Red Eyes");
            movie1.setStudio("NewRetroWave");
            movie1.setVideoGenreId(SYNTHWAVE_NUMBER);
            movie1.setDescription("The lights of the city and passing cars roll across the " +
                    "pearlescent paint of the hood in a hypnotizing pattern. the black gloves creaks " +
                    "while it grips the shifter and kicks it up a gear. Right then you realize it isn't " +
                    "the destination, it's the journey.");
            movie1.setCardImageUrl("http://i1.ytimg.com/vi/NZf15xVrOW8/maxresdefault.jpg");
            //movie1.setVideoUrl("http://corochann.com/wp-content/uploads/2015/07/MVI_0949.mp4");
            /* Google sample app's movie */
            movie1.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video4.mp4");
            mItems.add(movie1);

            Movie movie2 = new Movie();
            movie2.setId(5);
            movie2.setTitle("Dynatron - Propulsion Overdrive");
            movie2.setStudio("Retro Electro Music");
            movie2.setVideoGenreId(SYNTHWAVE_NUMBER);
            movie2.setDescription("The sound of the inner robot in you waiting to burst open and " +
                    "lead the way of the treacherous journey that lies ahead");
            movie2.setCardImageUrl("http://i1.ytimg.com/vi/pKHRerwGXwU/maxresdefault.jpg");
            //movie2.setVideoUrl("http://corochann.com/wp-content/uploads/2015/07/MVI_0962.mp4");
            /* Google sample app's movie */
            movie2.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video5.mp4");
            mItems.add(movie2);

            Movie movie3 = new Movie();
            movie3.setId(6);
            movie3.setTitle("Miami Nights 1984 - Accelerated");
            movie3.setStudio("NewRetroWave");
            movie3.setVideoGenreId(SYNTHWAVE_NUMBER);
            movie3.setDescription("This stuff has more views than some mainstream shitty artists," +
                    "which tells us that people are hungry for quality. Support the underground people");
            movie3.setCardImageUrl("http://i1.ytimg.com/vi/52_uFG27EJQ/maxresdefault.jpg");
            movie3.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video6.mp4");
            mItems.add(movie3);
        }
        else if(channelNumber==HIP_HOP_NUMBER){
            mItems = null;
            mItems = new ArrayList<Movie>();
            Movie movie1 = new Movie();
            movie1.setId(7);
            movie1.setTitle("Best Rap Freestyle Battle Hip Hop Instrumental Beat");
            movie1.setStudio("Hip Hop Beats");
            movie1.setVideoGenreId(HIP_HOP_NUMBER);
            movie1.setDescription("Guns dont kill people rappers do, Ask any politican and they'll " +
                    "tell you its true, Its a fact music makes you violent, Like Michael Jackson telling " +
                    "little Timmy to be silent, You don't believe me? Heres my hype, Offer me the record" +
                    " and i'll show you the type, Of criminal this rap shit is breedin, Its a fact that " +
                    "MC Hammer left me bleedin, Vanilla Ice made my mother say 'Fuck', If I stuck with UB40 " +
                    "then I woulda been in luck...");
            movie1.setCardImageUrl("http://i1.ytimg.com/vi/D7ghIuf0V-o/maxresdefault.jpg");
            movie1.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video7.mp4");
            mItems.add(movie1);

            Movie movie2 = new Movie();
            movie2.setId(8);
            movie2.setTitle("Hard Hip-Hop Rap Instrumental/Beat 2017");
            movie2.setStudio("Shintek Beats");
            movie2.setVideoGenreId(HIP_HOP_NUMBER);
            movie2.setDescription("Try and hide cyanide suicide homocide this violence's got the " +
                    "country on overdrive if i were to sit in silience would i help this violence " +
                    "cuz we got people dying and fight for this country when they snap at us we snap " +
                    "back like a bungee i hate to put this blunty but we aint gonna sop kill abruptly " +
                    "when he got new ammunition coming in monthly we've turned into bloof hungry " +
                    "junkies i dont if i should is it funny?");
            movie2.setCardImageUrl("http://i1.ytimg.com/vi/GtQhz6YMwPg/maxresdefault.jpg");
            movie2.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video8.mp4");
            mItems.add(movie2);

            Movie movie3 = new Movie();
            movie3.setId(9);
            movie3.setTitle("Freestyle Rap Instrumental Beat ");
            movie3.setStudio("Hip Hop Beats");
            movie3.setVideoGenreId(HIP_HOP_NUMBER);
            movie3.setDescription("Well.. what i hear you say is quite sad./ " +
                    "you tell, you try to live the life that you had./ but still telling how you " +
                    "ruining the shit with crack./ I also finds it stupid, that a matter of fact./" +
                    "Lost many friends, i can't tolerate that crap./ you think it's smart, but you " +
                    "are a hostile./ the crack desires how 'n when you gonna go wild./ i'm not talking " +
                    "about being famous and going worldwide./ i'm talking about the temper and how you " +
                    "quickly can ends up on the other side./");
            movie3.setCardImageUrl("http://i1.ytimg.com/vi/A8ri9nw6LA4/maxresdefault.jpg");
            movie3.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video9.mp4");
            mItems.add(movie3);
        }
        else if(channelNumber==ROCK_NUMBER){
            mItems = null;
            mItems = new ArrayList<Movie>();
            Movie movie1 = new Movie();
            movie1.setId(10);
            movie1.setTitle("Rock Instrumental/Beat \"Rock The House\"");
            movie1.setStudio("JurdBeats");
            movie1.setVideoGenreId(ROCK_NUMBER);
            movie1.setDescription("Distorted rock guitars dominate this instrumental beat." +
                    " I also tried to give it a realistic band sound. There are less synth sounds " +
                    "this time. All guitars played and recorded by Lost in Scores. Have fun!");
            movie1.setCardImageUrl("http://i1.ytimg.com/vi/QRETOsb9cj8/maxresdefault.jpg");
            //movie1.setVideoUrl("http://corochann.com/wp-content/uploads/2015/07/MVI_0949.mp4");
            /* Google sample app's movie */
            movie1.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video10.mp4");
            mItems.add(movie1);

            Movie movie2 = new Movie();
            movie2.setId(11);
            movie2.setTitle("Progressive Instrumental Rock (Melodic Lead Guitar) - \"JB\"");
            movie2.setStudio("Melodic Guitar Rock");
            movie2.setVideoGenreId(ROCK_NUMBER);
            movie2.setDescription("A nice melodic lead guitar focused progressive rock tune by the " +
                    "russian band \"nobody.one\". I like the experimental but still melodic lead part " +
                    "and with that sweet super reverbed tone.");
            movie2.setCardImageUrl("http://i1.ytimg.com/vi/9YR7b20Maig/maxresdefault.jpg");
            //movie2.setVideoUrl("http://corochann.com/wp-content/uploads/2015/07/MVI_0962.mp4");
            /* Google sample app's movie */
            movie2.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video11.mp4");
            mItems.add(movie2);

            Movie movie3 = new Movie();
            movie3.setId(12);
            movie3.setTitle("Rock/Metal Instrumental_Beat \"Above it All\"");
            movie3.setStudio("JurdBeats");
            movie3.setVideoGenreId(ROCK_NUMBER);
            movie3.setDescription("License this instrumental at http://JurdBeats.com The title is " +
                    "\"Above it All\" Receive the high quality wav file and " +
                    "also untagged version when licensing.");
            movie3.setCardImageUrl("http://i1.ytimg.com/vi/D47GDTt9Vss/maxresdefault.jpg");
            movie3.setVideoUrl("https://raw.githubusercontent.com/Karabas911/SimpleJavaCode/master/video12.mp4");
            mItems.add(movie3);
        }
        return mItems;
    }

    public static ArrayList<Movie> getMovieItems() {
        ArrayList<Movie> mItems2 = new ArrayList<Movie>();
        for(int channelId: ALL_CHANNELS){
            for(Movie movie: getMovieItems(channelId)) mItems2.add(movie);
        }
        return mItems2;
    }


}