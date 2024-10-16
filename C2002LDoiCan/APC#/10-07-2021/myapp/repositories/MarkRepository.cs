using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using HtmlAgilityPack;
using myapp.models;
using NUglify;

namespace myapp.repositories {
    public class MarkRepository {
        public IEnumerable<Mark> marks { get; set; }
        public void GetMarks() {
            //https://thanhnien.vn/ajax/diemthi.aspx?kythi=THCS&nam=2020&city=TPHCM&text=12345
            string html = string.Empty;
            string url = @"https://thanhnien.vn/ajax/diemthi.aspx?kythi=THCS&nam=2020&city=TPHCM&text=12345";
            try {               
                var web = new HtmlWeb();
                var doc = web.Load(url);
                foreach(var childNode in doc.DocumentNode.ChildNodes) {
                    Console.WriteLine("aa");
                }
                Console.WriteLine(html);
            } catch(Exception ex) {
                Console.WriteLine(ex.ToString());
            }

        }
    }
}