namespace exam5.Models {
    public interface IGood {
        public int Price {get; set;}
        public string Stock { get; set; }
        public float VAT { get; }
        public float PriceCal { get; }
    }
}