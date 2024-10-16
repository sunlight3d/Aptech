using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Diagnostics;
using Microsoft.AspNetCore.Mvc.Filters;

namespace ControllersExample.Filters
{
    public class CustomActionFilter : ActionFilterAttribute
    {

        public override void OnActionExecuted(ActionExecutedContext context) {
            string viewData = context.Result.ToString() ?? "";
            Console.WriteLine("OnActionExecuted");//3
        }
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            string actionName = context.ActionDescriptor.RouteValues["action"];            
            string controllerName = context.ActionDescriptor.RouteValues["controller"];
            var x = context.ActionDescriptor.RouteValues;
            Debug.WriteLine(">>> " + actionName + " started, event fired: OnActionExecuting");
            Console.WriteLine("OnActionExecuting");//1, 2, implement Index()
        }

        //[DebuggerStepThrough]
        /*
        public override async Task OnActionExecutionAsync(ActionExecutingContext context,
            ActionExecutionDelegate next)
        {
            Console.WriteLine("OnActionExecutionAsync");//1, 2.implement Index()
            var resultContext = await next();
        }
        */

        public override void OnResultExecuted(ResultExecutedContext context)
        {
            string actionName = context.ActionDescriptor.RouteValues["action"];
            string viewData = context.Result.ToString() ?? "";
            string controllerName = context.ActionDescriptor.RouteValues["controller"];
            var x = context.ActionDescriptor.RouteValues;
            Debug.WriteLine(">>> " + actionName + " started, event fired: OnResultExecuted");
            Console.WriteLine("OnResultExecuted");//5
        }

        public override void OnResultExecuting(ResultExecutingContext context)
        {
            string viewData = context.Result.ToString() ?? "";
            Console.WriteLine("OnResultExecuting");//4

        }
        //[DebuggerStepThrough]
        /*
        public override async Task OnResultExecutionAsync(ResultExecutingContext context, 
            ResultExecutionDelegate next)
        {
            Console.WriteLine("OnResultExecutionAsync");//3
            var resultContext = await next();
            
        }
        */
    }
}
