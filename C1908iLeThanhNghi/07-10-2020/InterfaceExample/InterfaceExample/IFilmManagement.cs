using System;
using System.Collections.Generic;
using System.Text;

namespace InterfaceExample
{
    public interface IFilmManagement
    {
        public void responseFilms(List<Film> films, Exception exception);
    }
}
