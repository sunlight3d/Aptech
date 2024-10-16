using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyApp.Models
{
    public class Grid
    {
        private Cell[,] cells;
        public int Rows { get; private set; }
        public int Cols { get; private set; }

        public Grid(int rows, int cols, int goldAmount)
        {
            Rows = rows;
            Cols = cols;
            cells = new Cell[rows, cols];

            var random = new Random();
            var goldCells = new List<Tuple<int, int>>();

            // Đặt vàng vào các ô trống ngẫu nhiên
            for (int i = 0; i < goldAmount; i++)
            {
                int row, col;
                do
                {
                    row = random.Next(rows);
                    col = random.Next(cols);
                } while (goldCells.Contains(Tuple.Create(row, col)));

                goldCells.Add(Tuple.Create(row, col));
            }

            // Tạo mảnh đất với các ô trống có chứa vàng
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    cells[i, j] = new Cell
                    {
                        Row = i,
                        Col = j,
                        HasGold = goldCells.Contains(Tuple.Create(i, j))
                    };                 
                }
            }
        }

        public Cell GetCell(int row, int col)
        {
            return cells[row, col];
        }
    }
}
