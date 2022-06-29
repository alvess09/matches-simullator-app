package com.alvesariel.matchessimullatorapp.data;

import com.alvesariel.matchessimullatorapp.domain.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {
    //captura os dados do EndPoint
    @GET("matches.json")
    Call<List<Match>> getMatches();


}
