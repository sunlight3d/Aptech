using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http.Controllers;
using System.Web.Http.Filters;

namespace RequestResponseFlow.Web
{
    public class TraceFilterAttribute : Attribute, IActionFilter
    {
        public async Task<HttpResponseMessage> 
            //continuation = goi den request tiep theo
            ExecuteActionFilterAsync(
                HttpActionContext actionContext, 
                CancellationToken cancellationToken, 
                Func<Task<HttpResponseMessage>> continuation)
        {            
            Trace.WriteLine("1. Trace filter start");

            foreach (var item in actionContext.ActionArguments.Keys)
                Trace.WriteLine(string.Format("{0}: {1}", item, actionContext.ActionArguments[item]));
            var response = await continuation();

            Trace.WriteLine(string.Format("Trace filter response: {0}", response));
            return response;
        }
        //method of IFilter
        public bool AllowMultiple
        {
            get { return true; }
        }
    }
}