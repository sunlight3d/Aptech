using Microsoft.Extensions.Options;
using MongoDB.Driver;
using WepApiDotNetCore.Models;

namespace WepApiDotNetCore.Services
{
    public class BooksService
    {
        private readonly IMongoCollection<Book> _booksCollection;
        public BooksService(IOptions<BookStoreDatabaseSettings> bookStoreDatabaseSettings)
        {
            var mongoClient = new MongoClient(
                bookStoreDatabaseSettings.Value.ConnectionString);

            var mongoDatabase = mongoClient.GetDatabase(
                bookStoreDatabaseSettings.Value.DatabaseName);

            _booksCollection = mongoDatabase.GetCollection<Book>(
                bookStoreDatabaseSettings.Value.BooksCollectionName);
            //db.Books
        }
        public async Task<List<Book>> GetAsync() =>
        await _booksCollection.Find(_ => true).ToListAsync();
        //db.Books.find()

        public async Task<Book?> GetAsync(string id) =>
            await _booksCollection.Find(x => x.Id == id).FirstOrDefaultAsync();
        //db.Books.find({id: OjjectId('dddddd')})

        public async Task CreateAsync(Book newBook) =>
            await _booksCollection.InsertOneAsync(newBook);

        public async Task UpdateAsync(string id, Book updatedBook) =>
            await _booksCollection.ReplaceOneAsync(x => x.Id == id, updatedBook);

        public async Task RemoveAsync(string id) =>
            await _booksCollection.DeleteOneAsync(x => x.Id == id);

    }
}
