using System;
namespace de06
{
	public interface IGood
	{        
		int Price { get; set; }
        string Stock { get; set; }
        float VAT { get;}
        float PriceCal { get; }
    }
}

