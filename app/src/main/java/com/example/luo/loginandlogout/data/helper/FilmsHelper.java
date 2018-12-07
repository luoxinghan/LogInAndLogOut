package com.example.luo.loginandlogout.data.helper;

import com.example.luo.loginandlogout.data.modules.Film;
import com.example.luo.loginandlogout.data.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class FilmsHelper {

    public static List<Film> createFilms(){
        List<Film> films = new ArrayList<Film>();
        films.add(new Film("film1","The Shawshank Redemption",DateUtil.getTheFormatDate("1994-09-10"), "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."));
        films.add(new Film("film2","Farewell My Concubine",DateUtil.getTheFormatDate("1993-01-01"),"The story of two men, who met as apprentices in the Peking Opera, and stayed friends for over 50 years."));
        films.add(new Film("film3","Leon",DateUtil.getTheFormatDate("1994-09-14"),"Mathilda, a 12-year-old girl, is reluctantly taken in by Léon, a professional assassin, after her family is murdered. Léon and Mathilda form an unusual relationship, as she becomes his protégée and learns the assassin's trade."));
        films.add(new Film("film4","Forrest Gump",DateUtil.getTheFormatDate("1994-06-23"),"The presidencies of Kennedy and Johnson, Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75."));
        films.add(new Film("film5","La vita è bella",DateUtil.getTheFormatDate("1997-12-20"),"When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp."));
        films.add(new Film("film6","Titanic",DateUtil.getTheFormatDate("1998-04-03"),"A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic."));
        films.add(new Film("film7","Spirited Away",DateUtil.getTheFormatDate("2001-07-20"),"During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts."));
        films.add(new Film("film8","Schindler's List",DateUtil.getTheFormatDate("1993-11-30"),"In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans."));
        films.add(new Film("film9","Inception",DateUtil.getTheFormatDate("2010-07-16"),"A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO."));
        films.add(new Film("film10","The Truman Show",DateUtil.getTheFormatDate("1998-06-05"),"An insurance salesman/adjuster discovers his entire life is actually a television show."));
        return films;
    }
}
