using java.text;
using Microsoft.AspNetCore.Rewrite;
using Microsoft.Extensions.FileSystemGlobbing.Internal;
using System.Text;

namespace DipplomaApp
{
    public class Utilities
    {

        public static String DeAccent(String str)
            => Encoding.UTF8.GetString(Encoding.GetEncoding("ISO-8859-8").GetBytes(str));
        public static bool CheckContain(string? string1, string? string2) {
            Console.WriteLine("haha");
            return Utilities.DeAccent(string1 ?? "").ToLower()
                .Contains(Utilities.DeAccent(string2 ?? "").ToLower());
        }
    }
}
