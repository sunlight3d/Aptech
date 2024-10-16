using DotNet.RestApi.Client;
using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace InterfaceExample
{
    public class Worker
    {
        public const string URL_FILMS = "https://reactnative.dev/movies.json";
        public async Task GetFilmsFromApi(IFilmManagement iFilmManagement) {
            try
            {
                //buoi sau se sua thanh timeout
                var uri = new Uri(URL_FILMS);
                RestApiClient client = new RestApiClient(uri);                
                HttpResponseMessage response = await client.SendJsonRequest(HttpMethod.Get, uri, null);
                string responseString = await response.Content.ReadAsStringAsync();
                List<Film> films = await response.DeseriaseJsonResponseAsync<List<Film>>();
                //xong xuoi roi, bao cho interface biet
                iFilmManagement.responseFilms(films, null);
            }
            catch (Exception exception) {
                iFilmManagement.responseFilms(new List<Film>(), exception);
            }


        }        
    }
}
