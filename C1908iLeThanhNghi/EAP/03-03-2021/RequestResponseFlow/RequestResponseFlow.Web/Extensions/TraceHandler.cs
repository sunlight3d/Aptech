using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

namespace RequestResponseFlow.Web.Extensions
{
    public class TraceHandler: DelegatingHandler
    {
        //Task: run async/ await
        protected override async Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, 
            CancellationToken cancellationToken)
        {
            //trace a request
            Trace.WriteLine("Trace Handler start");
            Trace.WriteLine(request);

            var response = await base.SendAsync(request, cancellationToken);
            Trace.WriteLine(response);
            Trace.WriteLine("3.Trace Handler end");

            return response;
        }

    }
}