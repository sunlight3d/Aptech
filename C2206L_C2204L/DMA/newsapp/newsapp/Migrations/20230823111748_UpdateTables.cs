using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace newsapp.Migrations
{
    /// <inheritdoc />
    public partial class UpdateTables : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_NewsList_Categories_CategoryID",
                table: "NewsList");

            migrationBuilder.DropForeignKey(
                name: "FK_NewsList_Users_UserID",
                table: "NewsList");

            migrationBuilder.DropPrimaryKey(
                name: "PK_NewsList",
                table: "NewsList");

            migrationBuilder.RenameTable(
                name: "NewsList",
                newName: "News");

            migrationBuilder.RenameIndex(
                name: "IX_NewsList_UserID",
                table: "News",
                newName: "IX_News_UserID");

            migrationBuilder.RenameIndex(
                name: "IX_NewsList_CategoryID",
                table: "News",
                newName: "IX_News_CategoryID");

            migrationBuilder.AddPrimaryKey(
                name: "PK_News",
                table: "News",
                column: "ID");

            migrationBuilder.AddForeignKey(
                name: "FK_News_Categories_CategoryID",
                table: "News",
                column: "CategoryID",
                principalTable: "Categories",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_News_Users_UserID",
                table: "News",
                column: "UserID",
                principalTable: "Users",
                principalColumn: "UserID",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_News_Categories_CategoryID",
                table: "News");

            migrationBuilder.DropForeignKey(
                name: "FK_News_Users_UserID",
                table: "News");

            migrationBuilder.DropPrimaryKey(
                name: "PK_News",
                table: "News");

            migrationBuilder.RenameTable(
                name: "News",
                newName: "NewsList");

            migrationBuilder.RenameIndex(
                name: "IX_News_UserID",
                table: "NewsList",
                newName: "IX_NewsList_UserID");

            migrationBuilder.RenameIndex(
                name: "IX_News_CategoryID",
                table: "NewsList",
                newName: "IX_NewsList_CategoryID");

            migrationBuilder.AddPrimaryKey(
                name: "PK_NewsList",
                table: "NewsList",
                column: "ID");

            migrationBuilder.AddForeignKey(
                name: "FK_NewsList_Categories_CategoryID",
                table: "NewsList",
                column: "CategoryID",
                principalTable: "Categories",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_NewsList_Users_UserID",
                table: "NewsList",
                column: "UserID",
                principalTable: "Users",
                principalColumn: "UserID",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
