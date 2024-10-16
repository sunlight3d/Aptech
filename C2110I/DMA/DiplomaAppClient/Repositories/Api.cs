using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace DipplomaApp.Repositories
{
    public class Api
    {
        public static async Task<string> SendGetRequestAsync(string url, Dictionary<string, string> parameters)
        {
            using var httpClient = new HttpClient();
            var response = await httpClient.GetAsync(url + ToQueryString(parameters));

            if (response.IsSuccessStatusCode)
            {
                return await response.Content.ReadAsStringAsync();
            }

            return "";
        }

        public static async Task<string> SendPostRequestAsync(string url, object data)
        {
            var json = JsonSerializer.Serialize(data);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            using var httpClient = new HttpClient();
            var response = await httpClient.PostAsync(url, content);

            if (response.IsSuccessStatusCode)
            {
                return await response.Content.ReadAsStringAsync();
            }
            //return JsonSerializer.Deserialize<T>(json);
            return null;
        }
        private static string ToQueryString(Dictionary<string, string> parameters)
        {
            if (parameters == null || parameters.Count == 0)
            {
                return string.Empty;
            }

            var queryString = new StringBuilder();

            foreach (var param in parameters)
            {
                if (queryString.Length == 0)
                {
                    queryString.Append('?');
                }
                else
                {
                    queryString.Append('&');
                }

                queryString.Append($"{Uri.EscapeDataString(param.Key)}={Uri.EscapeDataString(param.Value)}");
            }

            return queryString.ToString();
        }
    }
}
