namespace BankTransferClient.Models
{
    public class User
    {
        public int UserId { get; set; }

        public string UserName { get; set; } = null!;

        public string UserPass { get; set; } = null!;

        public string FullName { get; set; } = null!;

        public string Address { get; set; } = null!;

        public string Phone { get; set; } = null!;

        public string Email { get; set; } = null!;

        public bool Status { get; set; }
    }
}
