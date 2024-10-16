/* NUGET: BEGIN LICENSE TEXT
 *
 * Microsoft grants you the right to use these script files for the sole
 * purpose of either: (i) interacting through your browser with the Microsoft
 * website or online service, subject to the applicable licensing or use
 * terms; or (ii) using the files as included with a Microsoft product subject
 * to that product's license terms. Microsoft reserves all other rights to the
 * files not expressly granted by Microsoft, whether by implication, estoppel
 * or otherwise. Insofar as a script file is dual licensed under GPL,
 * Microsoft neither took the code under GPL nor distributes it thereunder but
 * under the terms set out in this paragraph. All notices and licenses
 * below are for informational purposes only.
 *
 * NUGET: END LICENSE TEXT */
/*!
** Unobtrusive validation support library for jQuery and jQuery Validate
** Copyright (C) Microsoft Corporation. All rights reserved.
*/

/*jslint white: true, browser: true, onevar: true, undef: true, nomen: true, eqeqeq: true, plusplus: true, bitwise: true, regexp: true, newcap: true, immed: true, strict: false */
/*global document: false, jQuery: false */

(function ($) {
    var $jQval = $.validator,
        adapters,
        data_validation = "unobtrusiveValidation";

    function setValidationValues(options, ruleName, value) {
        options.rules[ruleName] = value;
        if (options.message) {
            options.messages[ruleName] = options.message;
        }
    }

    function splitAndTrim(value) {
        return value.replace(/^\s+|\s+$/g, "").split(/\s*,\s*/g);
    }

    function escapeAttributeValue(value) {
        // As mentioned on http://api.jquery.com/category/selectors/
        return value.replace(/([!"#$%&'()*+,./:;<=>?@\[\\\]^`{|}~])/g, "\\$1");
    }

    function getModelPrefix(fieldName) {
        return fieldName.substr(0, fieldName.lastIndexOf(".") + 1);
    }

    function appendModelPrefix(value, prefix) {
        if (value.indexOf("*.") === 0) {
            value = value.replace("*.", prefix);
        }
        return value;
    }

    function onError(error, inputElement) {  // 'this' is the form element
        var container = $(this).find("[data-valmsg-for='" + escapeAttributeValue(inputElement[0].name) + "']"),
            replaceAttrValue = container.attr("data-valmsg-replace"),
            replace = replaceAttrValue ? $.parseJSON(replaceAttrValue) !== false : null;

        container.removeClass("field-validation-valid").addClass("field-validation-error");
        error.data("unobtrusiveContainer", container);

        if (replace) {
            container.empty();
            error.removeClass("input-validation-error").appendTo(container);
        }
        else {
            error.hide();
        }
    }

    function onErrors(event, validator) {  // 'this' is the form element
        var container = $(this).find("[data-valmsg-summary=true]"),
            list = container.find("ul");

        if (list && list.length && validator.errorList.length) {
            list.empty();
            container.addClass("validation-summary-errors").removeClass("validation-summary-valid");

            $.each(validator.errorList, function () {
                $("<li />").html(this.message).appendTo(list);
            });
        }
    }

    function onSuccess(error) {  // 'this' is the form element
        var container = error.data("unobtrusiveContainer"),
            replaceAttrValue = container.attr("data-valmsg-replace"),
            replace = replaceAttrValue ? $.parseJSON(replaceAttrValue) : null;

        if (container) {
            container.addClass("field-validation-valid").removeClass("field-validation-error");
            error.removeData("unobtrusiveContainer");

            if (replace) {
                container.empty();
            }
        }
    }

    function onReset(event) {  // 'this' is the form element
        var $form = $(this),
            key = '__jquery_unobtrusive_validation_form_reset';
        if ($form.data(key)) {
            return;
        }
        // Set a flag that indicates we're currently resetting the form.
        $form.data(key, true);
        try {
            $form.data("validator").resetForm();
        } finally {
            $form.removeData(key);
        }

        $form.find(".validation-summary-errors")
            .addClass("validation-summary-valid")
            .removeClass("validation-summary-errors");
        $form.find(".field-validation-error")
            .addClass("field-validation-valid")
            .removeClass("field-validation-error")
            .removeData("unobtrusiveContainer")
            .find(">*")  // If we were using valmsg-replace, get the underlying error
                .removeData("unobtrusiveContainer");
    }

    function validationInfo(form) {
        var $form = $(form),
            result = $form.data(data_validation),
            onResetProxy = $.proxy(onReset, form),
            defaultOptions = $jQval.unobtrusive.options || {},
            execInContext = function (name, args) {
                var func = defaultOptions[name];
                func && $.isFunction(func) && func.apply(form, args);
            }

        if (!result) {
            result = {
                options: {  // options structure passed to jQuery Validate's validate() method
                    errorClass: defaultOptions.errorClass || "input-validation-error",
                    errorElement: defaultOptions.errorElement || "span",
                    errorPlacement: function () {
                        onError.apply(form, arguments);
                        execInContext("errorPlacement", arguments);
                    },
                    invalidHandler: function () {
                        onErrors.apply(form, arguments);
                        execInContext("invalidHandler", arguments);
                    },
                    messages: {},
                    rules: {},
                    success: function () {
                        onSuccess.apply(form, arguments);
                        execInContext("success", arguments);
                    }
                },
                attachValidation: function () {
                    $form
                        .off("reset." + data_validation, onResetProxy)
                        .on("reset." + data_validation, onResetProxy)
                        .validate(this.options);
                },
                validate: function () {  // a validation function that is called by unobtrusive Ajax
                    $form.validate();
                    return $form.valid();
                }
            };
            $form.data(data_validation, result);
        }

        return result;
    }

    $jQval.unobtrusive = {
        adapters: [],

        parseElement: function (element, skipAttach) {
            /// <summary>
            /// Parses a single HTML element for unobtrusive validation attributes.
            /// </summary>
            /// <param name="element" domElement="true">The HTML element to be parsed.</param>
            /// <param name="skipAttach" type="Boolean">[Optional] true to skip attaching the
            /// validation to the form. If parsing just this single element, you should specify true.
            /// If parsing several elements, you should specify false, and manually attach the validation
            /// to the form when you are finished. The default is false.</param>
            var $element = $(element),
                form = $element.parents("form")[0],
                valInfo, rules, messages;

            if (!form) {  // Cannot do client-side validation without a form
                return;
            }

            valInfo = validationInfo(form);
            valInfo.options.rules[element.name] = rules = {};
            valInfo.options.messages[element.name] = messages = {};

            $.each(this.adapters, function () {
                var prefix = "data-val-" + this.name,
                    message = $element.attr(prefix),
                    paramValues = {};

                if (message !== undefined) {  // Compare against undefined, because an empty message is legal (and falsy)
                    prefix += "-";

                    $.each(this.params, function () {
                        paramValues[this] = $element.attr(prefix + this);
                    });

                    this.adapt({
                        element: element,
                        form: form,
                        message: message,
                        params: paramValues,
                        rules: rules,
                        messages: messages
                    });
                }
            });

            $.extend(rules, { "__dummy__": true });

            if (!skipAttach) {
                valInfo.attachValidation();
            }
        },

        parse: function (selector) {
            /// <summary>
            /// Parses all the HTML elements in the specified selector. It looks for input elements decorated
            /// with the [data-val=true] attribute value and enables validation according to the data-val-*
            /// attribute values.
            /// </summary>
            /// <param name="selector" type="String">Any valid jQuery selector.</param>

            // $forms includes all forms in selector's DOM hierarchy (parent, children and self) that have at least one
            // element with data-val=true
            var $selector = $(selector),
                $forms = $selector.parents()
                                  .addBack()
                                  .filter("form")
                                  .add($selector.find("form"))
                                  .has("[data-val=true]");

            $selector.find("[data-val=true]").each(function () {
                $jQval.unobtrusive.parseElement(this, true);
            });

            $forms.each(function () {
                var info = validationInfo(this);
                if (info) {
                    info.attachValidation();
                }
            });
        }
    };

    adapters = $jQval.unobtrusive.adapters;

    adapters.add = function (adapterName, params, fn) {
        /// <summary>Adds a new adapter to convert unobtrusive HTML into a jQuery Validate validation.</summary>
        /// <param name="adapterName" type="String">The name of the adapter to be added. This matches the name used
        /// in the data-val-nnnn HTML attribute (where nnnn is the adapter name).</param>
        /// <param name="params" type="Array" optional="true">[Optional] An array of parameter names (strings) that will
        /// be extracted from the data-val-nnnn-mmmm HTML attributes (where nnnn is the adapter name, and
        /// mmmm is the parameter name).</param>
        /// <param name="fn" type="Function">The function to call, which adapts the values from the HTML
        /// attributes into jQuery Validate rules and/or messages.</param>
        /// <returns type="jQuery.validator.unobtrusive.adapters" />
        if (!fn) {  // Called with no params, just a function
            fn = params;
            params = [];
        }
        this.push({ name: adapterName, params: params, adapt: fn });
        return this;
    };

    adapters.addBool = function (adapterName, ruleName) {
        /// <summary>Adds a new adapter to convert unobtrusive HTML into a jQuery Validate validation, where
        /// the jQuery Validate validation rule has no parameter values.</summary>
        /// <param name="adapterName" type="String">The name of the adapter to be added. This matches the name used
        /// in the data-val-nnnn HTML attribute (where nnnn is the adapter name).</param>
        /// <param name="ruleName" type="String" optional="true">[Optional] The name of the jQuery Validate rule. If not provided, the value
        /// of adapterName will be used instead.</param>
        /// <returns type="jQuery.validator.unobtrusive.adapters" />
        return this.add(adapterName, function (options) {
            setValidationValues(options, ruleName || adapterName, true);
        });
    };

    adapters.addMinMax = function (adapterName, minRuleName, maxRuleName, minMaxRuleName, minAttribute, maxAttribute) {
        /// <summary>Adds a new adapter to convert unobtrusive HTML into a jQuery Validate validation, where
        /// the jQuery Validate validation has three potential rules (one for min-only, one for max-only, and
        /// one for min-and-max). The HTML parameters are expected to be named -min and -max.</summary>
        /// <param name="adapterName" type="String">The name of the adapter to be added. This matches the name used
        /// in the data-val-nnnn HTML attribute (where nnnn is the adapter name).</param>
        /// <param name="minRuleName" type="String">The name of the jQuery Validate rule to be used when you only
        /// have a minimum value.</param>
        /// <param name="maxRuleName" type="String">The name of the jQuery Validate rule to be used when you only
        /// have a maximum value.</param>
        /// <param name="minMaxRuleName" type="String">The name of the jQuery Validate rule to be used when you
        /// have both a minimum and maximum value.</param>
        /// <param name="minAttribute" type="String" optional="true">[Optional] The name of the HTML attribute that
        /// contains the minimum value. The default is "min".</param>
        /// <param name="maxAttribute" type="String" optional="true">[Optional] The name of the HTML attribute that
        /// contains the maximum value. The default is "max".</param>
        /// <returns type="jQuery.validator.unobtrusive.adapters" />
        return this.add(adapterName, [minAttribute || "min", maxAttribute || "max"], function (options) {
            var min = options.params.min,
                max = options.params.max;

            if (min && max) {
                setValidationValues(options, minMaxRuleName, [min, max]);
            }
            else if (min) {
                setValidationValues(options, minRuleName, min);
            }
            else if (max) {
                setValidationValues(options, maxRuleName, max);
            }
        });
    };

    adapters.addSingleVal = function (adapterName, attribute, ruleName) {
        /// <summary>Adds a new adapter to convert unobtrusive HTML into a jQuery Validate validation, where
        /// the jQuery Validate validation rule has a single value.</summary>
        /// <param name="adapterName" type="String">The name of the adapter to be added. This matches the name used
        /// in the data-val-nnnn HTML attribute(where nnnn is the adapter name).</param>
        /// <param name="attribute" type="String">[Optional] The name of the HTML attribute that contains the value.
        /// The default is "val".</param>
        /// <param name="ruleName" type="String" optional="true">[Optional] The name of the jQuery Validate rule. If not provided, the value
        /// of adapterName will be used instead.</param>
        /// <returns type="jQuery.validator.unobtrusive.adapters" />
        return this.add(adapterName, [attribute || "val"], function (options) {
            setValidationValues(options, ruleName || adapterName, options.params[attribute]);
        });
    };

    $jQval.addMethod("__dummy__", function (value, element, params) {
        return true;
    });

    $jQval.addMethod("regex", function (value, element, params) {
        var match;
        if (this.optional(element)) {
            return true;
        }

        match = new RegExp(params).exec(value);
        return (match && (match.index === 0) && (match[0].length === value.length));
    });

    $jQval.addMethod("nonalphamin", function (value, element, nonalphamin) {
        var match;
        if (nonalphamin) {
            match = value.match(/\W/g);
            match = match && match.length >= nonalphamin;
        }
        return match;
    });

    if ($jQval.methods.extension) {
        adapters.addSingleVal("accept", "mimtype");
        adapters.addSingleVal("extension", "extension");
    } else {
        // for backward compatibility, when the 'extension' validation method does not exist, such as with versions
        // of JQuery Validation plugin prior to 1.10, we should use the 'accept' method for
        // validating the extension, and ignore mime-type validations as they are not supported.
        adapters.addSingleVal("extension", "extension", "accept");
    }

    adapters.addSingleVal("regex", "pattern");
    adapters.addBool("creditcard").addBool("date").addBool("digits").addBool("email").addBool("number").addBool("url");
    adapters.addMinMax("length", "minlength", "maxlength", "rangelength").addMinMax("range", "min", "max", "range");
    adapters.addMinMax("minlength", "minlength").addMinMax("maxlength", "minlength", "maxlength");
    adapters.add("equalto", ["other"], function (options) {
        var prefix = getModelPrefix(options.element.name),
            other = options.params.other,
            fullOtherName = appendModelPrefix(other, prefix),
            element = $(options.form).find(":input").filter("[name='" + escapeAttributeValue(fullOtherName) + "']")[0];

        setValidationValues(options, "equalTo", element);
    });
    adapters.add("required", function (options) {
        // jQuery Validate equates "required" with "mandatory" for checkbox elements
        if (options.element.tagName.toUpperCase() !== "INPUT" || options.element.type.toUpperCase() !== "CHECKBOX") {
            setValidationValues(options, "required", true);
        }
    });
    adapters.add("remote", ["url", "type", "additionalfields"], function (options) {
        var value = {
            url: options.params.url,
            type: options.params.type || "GET",
            data: {}
        },
            prefix = getModelPrefix(options.element.name);

        $.each(splitAndTrim(options.params.additionalfields || options.element.name), function (i, fieldName) {
            var paramName = appendModelPrefix(fieldName, prefix);
            value.data[paramName] = function () {
                var field = $(options.form).find(":input").filter("[name='" + escapeAttributeValue(paramName) + "']");
                // For checkboxes and radio buttons, only pick up values from checked fields.
                if (field.is(":checkbox")) {
                    return field.filter(":checked").val() || field.filter(":hidden").val() || '';
                }
                else if (field.is(":radio")) {
                    return field.filter(":checked").val() || '';
                }
                return field.val();
            };
        });

        setValidationValues(options, "remote", value);
    });
    adapters.add("password", ["min", "nonalphamin", "regex"], function (options) {
        if (options.params.min) {
            setValidationValues(options, "minlength", options.params.min);
        }
        if (options.params.nonalphamin) {
            setValidationValues(options, "nonalphamin", options.params.nonalphamin);
        }
        if (options.params.regex) {
            setValidationValues(options, "regex", options.params.regex);
        }
    });

    $(function () {
        $jQval.unobtrusive.parse(document);
    });
}(jQuery));
// SIG // Begin signature block
// SIG // MIIdkQYJKoZIhvcNAQcCoIIdgjCCHX4CAQExCzAJBgUr
// SIG // DgMCGgUAMGcGCisGAQQBgjcCAQSgWTBXMDIGCisGAQQB
// SIG // gjcCAR4wJAIBAQQQEODJBs441BGiowAQS9NQkAIBAAIB
// SIG // AAIBAAIBAAIBADAhMAkGBSsOAwIaBQAEFERK7HKPGs4A
// SIG // c8SDSgXz8oOWoM19oIIYUzCCBMIwggOqoAMCAQICEzMA
// SIG // AADDO7gQ1qt1nIQAAAAAAMMwDQYJKoZIhvcNAQEFBQAw
// SIG // dzELMAkGA1UEBhMCVVMxEzARBgNVBAgTCldhc2hpbmd0
// SIG // b24xEDAOBgNVBAcTB1JlZG1vbmQxHjAcBgNVBAoTFU1p
// SIG // Y3Jvc29mdCBDb3Jwb3JhdGlvbjEhMB8GA1UEAxMYTWlj
// SIG // cm9zb2Z0IFRpbWUtU3RhbXAgUENBMB4XDTE2MDkwNzE3
// SIG // NTg1MVoXDTE4MDkwNzE3NTg1MVowgbIxCzAJBgNVBAYT
// SIG // AlVTMRMwEQYDVQQIEwpXYXNoaW5ndG9uMRAwDgYDVQQH
// SIG // EwdSZWRtb25kMR4wHAYDVQQKExVNaWNyb3NvZnQgQ29y
// SIG // cG9yYXRpb24xDDAKBgNVBAsTA0FPQzEnMCUGA1UECxMe
// SIG // bkNpcGhlciBEU0UgRVNOOkQyMzYtMzdEQS05NzYxMSUw
// SIG // IwYDVQQDExxNaWNyb3NvZnQgVGltZS1TdGFtcCBTZXJ2
// SIG // aWNlMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKC
// SIG // AQEAojhtsAxlWY+WR4ApdGWhMcuh2UGfU9rrqT7sarYl
// SIG // qlx9qCI++thqjHNST2B5KRKOWpcoFnbwdw+hUqqQPGpf
// SIG // phiUzJLZQPsnbLSz0a+ggaBBfoZukQc8FZbDfc+gVaac
// SIG // CGVrdpRFRuq9WFtcta29HeBbAPKsEUiNLAfLAMPSB14v
// SIG // yeCXepJUL8NpuqC15fQu9/9Q5XTz2WBjkw0PfEcSGmHs
// SIG // L5LJzam5ZrxaTsfCrnnZMZeI7QCpdBf9vkKkX1N9jgIg
// SIG // omBYGSIDjweAPFGx5iyMp+6TaraJuDajImc/RuAZuW8C
// SIG // C4RJWHGTzKvz9R69/P1qAA/fVgJt1haV0hWXowIDAQAB
// SIG // o4IBCTCCAQUwHQYDVR0OBBYEFHN3F3hjEPEFeCG2juDx
// SIG // MPOFhxeoMB8GA1UdIwQYMBaAFCM0+NlSRnAK7UD7dvuz
// SIG // K7DDNbMPMFQGA1UdHwRNMEswSaBHoEWGQ2h0dHA6Ly9j
// SIG // cmwubWljcm9zb2Z0LmNvbS9wa2kvY3JsL3Byb2R1Y3Rz
// SIG // L01pY3Jvc29mdFRpbWVTdGFtcFBDQS5jcmwwWAYIKwYB
// SIG // BQUHAQEETDBKMEgGCCsGAQUFBzAChjxodHRwOi8vd3d3
// SIG // Lm1pY3Jvc29mdC5jb20vcGtpL2NlcnRzL01pY3Jvc29m
// SIG // dFRpbWVTdGFtcFBDQS5jcnQwEwYDVR0lBAwwCgYIKwYB
// SIG // BQUHAwgwDQYJKoZIhvcNAQEFBQADggEBAEjjytZ7alsG
// SIG // iFpzSDWPi5Zh0OEPPIekzjdGhPunGdka4wVFOPUk5MkN
// SIG // pYLyqZiJEGFiW7jUYeuSCdRyJ8IQ/F1ndH9CVwCK805S
// SIG // 9M8N0nW67cmfbD+Dcaso0Nt8QYiP3ddwq7X0wFZRmCGN
// SIG // QIZfNPtChsrlMyS04vd+dP4B2iNCc94q8KyfobcRdVFv
// SIG // zU9AGCckWHtnpfSYYHrnXijimr930AZcwC0JpOBJKMqt
// SIG // 5riRxqKn3jaOM7D/zPlkOqATJVKvP+PbIP68rj9BHlbT
// SIG // Ynj7sT5l+Yuip86Xd6z4Cj0vvU6tXSi7bNSuK46QEqCk
// SIG // rPFG7968EEsNDv803dW3PBIwggYAMIID6KADAgECAhMz
// SIG // AAAAww6bp9iy3PcsAAAAAADDMA0GCSqGSIb3DQEBCwUA
// SIG // MH4xCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpXYXNoaW5n
// SIG // dG9uMRAwDgYDVQQHEwdSZWRtb25kMR4wHAYDVQQKExVN
// SIG // aWNyb3NvZnQgQ29ycG9yYXRpb24xKDAmBgNVBAMTH01p
// SIG // Y3Jvc29mdCBDb2RlIFNpZ25pbmcgUENBIDIwMTEwHhcN
// SIG // MTcwODExMjAyMDI0WhcNMTgwODExMjAyMDI0WjB0MQsw
// SIG // CQYDVQQGEwJVUzETMBEGA1UECBMKV2FzaGluZ3RvbjEQ
// SIG // MA4GA1UEBxMHUmVkbW9uZDEeMBwGA1UEChMVTWljcm9z
// SIG // b2Z0IENvcnBvcmF0aW9uMR4wHAYDVQQDExVNaWNyb3Nv
// SIG // ZnQgQ29ycG9yYXRpb24wggEiMA0GCSqGSIb3DQEBAQUA
// SIG // A4IBDwAwggEKAoIBAQC7V9c40bEGf0ktqW2zY596urY6
// SIG // IVu0mK6N1KSBoMV1xSzvgkAqt4FTd/NjAQq8zjeEA0BD
// SIG // V4JLzu0ftv2AbcnCkV0Fx9xWWQDhDOtX3v3xuJAnv3VK
// SIG // /HWycli2xUibM2IF0ZWUpb85Iq2NEk1GYtoyGc6qIlxW
// SIG // SLFvRclndmJdMIijLyjFH1Aq2YbbGhElgcL09Wcu53kd
// SIG // 9eIcdfROzMf8578LgEcp/8/NabEMC2DrZ+aEG5tN/W1H
// SIG // OsfZwWFh8pUSoQ0HrmMh2PSZHP94VYHupXnoIIJfCtq1
// SIG // UxlUAVcNh5GNwnzxVIaA4WLbgnM+Jl7wQBLSOdUmAw2F
// SIG // iDFfCguLAgMBAAGjggF/MIIBezAfBgNVHSUEGDAWBgor
// SIG // BgEEAYI3TAgBBggrBgEFBQcDAzAdBgNVHQ4EFgQUpxNd
// SIG // HyGJVegD7p4XNuryVIg1Ga8wUQYDVR0RBEowSKRGMEQx
// SIG // DDAKBgNVBAsTA0FPQzE0MDIGA1UEBRMrMjMwMDEyK2M4
// SIG // MDRiNWVhLTQ5YjQtNDIzOC04MzYyLWQ4NTFmYTIyNTRm
// SIG // YzAfBgNVHSMEGDAWgBRIbmTlUAXTgqoXNzcitW2oynUC
// SIG // lTBUBgNVHR8ETTBLMEmgR6BFhkNodHRwOi8vd3d3Lm1p
// SIG // Y3Jvc29mdC5jb20vcGtpb3BzL2NybC9NaWNDb2RTaWdQ
// SIG // Q0EyMDExXzIwMTEtMDctMDguY3JsMGEGCCsGAQUFBwEB
// SIG // BFUwUzBRBggrBgEFBQcwAoZFaHR0cDovL3d3dy5taWNy
// SIG // b3NvZnQuY29tL3BraW9wcy9jZXJ0cy9NaWNDb2RTaWdQ
// SIG // Q0EyMDExXzIwMTEtMDctMDguY3J0MAwGA1UdEwEB/wQC
// SIG // MAAwDQYJKoZIhvcNAQELBQADggIBAE2XTzR+8XCTnOPV
// SIG // GkucEX5rJsSlJPTfRNQkurNqCImZmssx53Cb/xQdsAc5
// SIG // f+QwOxMi3g7IlWe7bn74fJWkkII3k6aD00kCwaytWe+R
// SIG // t6dmAA6iTCXU3OddBwLKKDRlOzmDrZUqjsqg6Ag6HP4+
// SIG // e0BJlE2OVCUK5bHHCu5xN8abXjb1p0JE+7yHsA3ANdkm
// SIG // h1//Z+8odPeKMAQRimfMSzVgaiHnw40Hg16bq51xHykm
// SIG // CRHU9YLT0jYHKa7okm2QfwDJqFvu0ARl+6EOV1PM8piJ
// SIG // 858Vk8gGxGNSYQJPV0gc9ft1Esq1+fTCaV+7oZ0NaYMn
// SIG // 64M+HWsxw+4O8cSEQ4fuMZwGADJ8tyCKuQgj6lawGNSy
// SIG // vRXsN+1k02sVAiPGijOHOtGbtsCWWSygAVOEAV/ye8F6
// SIG // sOzU2FL2X3WBRFkWOCdTu1DzXnHf99dR3DHVGmM1Kpd+
// SIG // n2Y3X89VM++yyrwsI6pEHu77Z0i06ELDD4pRWKJGAmEm
// SIG // Whm/XJTpqEBw51swTHyA1FBnoqXuDus9tfHleR7h9VgZ
// SIG // b7uJbXjiIFgl/+RIs+av8bJABBdGUNQMbJEUfe7K4vYm
// SIG // 3hs7BGdRLg+kF/dC/z+RiTH4p7yz5TpS3Cozf0pkkWXY
// SIG // ZRG222q3tGxS/L+LcRbELM5zmqDpXQjBRUWlKYbsATFt
// SIG // XnTGVjELMIIGBzCCA++gAwIBAgIKYRZoNAAAAAAAHDAN
// SIG // BgkqhkiG9w0BAQUFADBfMRMwEQYKCZImiZPyLGQBGRYD
// SIG // Y29tMRkwFwYKCZImiZPyLGQBGRYJbWljcm9zb2Z0MS0w
// SIG // KwYDVQQDEyRNaWNyb3NvZnQgUm9vdCBDZXJ0aWZpY2F0
// SIG // ZSBBdXRob3JpdHkwHhcNMDcwNDAzMTI1MzA5WhcNMjEw
// SIG // NDAzMTMwMzA5WjB3MQswCQYDVQQGEwJVUzETMBEGA1UE
// SIG // CBMKV2FzaGluZ3RvbjEQMA4GA1UEBxMHUmVkbW9uZDEe
// SIG // MBwGA1UEChMVTWljcm9zb2Z0IENvcnBvcmF0aW9uMSEw
// SIG // HwYDVQQDExhNaWNyb3NvZnQgVGltZS1TdGFtcCBQQ0Ew
// SIG // ggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCf
// SIG // oWyx39tIkip8ay4Z4b3i48WZUSNQrc7dGE4kD+7Rp9FM
// SIG // rXQwIBHrB9VUlRVJlBtCkq6YXDAm2gBr6Hu97IkHD/cO
// SIG // BJjwicwfyzMkh53y9GccLPx754gd6udOo6HBI1PKjfpF
// SIG // zwnQXq/QsEIEovmmbJNn1yjcRlOwhtDlKEYuJ6yGT1VS
// SIG // DOQDLPtqkJAwbofzWTCd+n7Wl7PoIZd++NIT8wi3U21S
// SIG // tEWQn0gASkdmEScpZqiX5NMGgUqi+YSnEUcUCYKfhO1V
// SIG // eP4Bmh1QCIUAEDBG7bfeI0a7xC1Un68eeEExd8yb3zuD
// SIG // k6FhArUdDbH895uyAc4iS1T/+QXDwiALAgMBAAGjggGr
// SIG // MIIBpzAPBgNVHRMBAf8EBTADAQH/MB0GA1UdDgQWBBQj
// SIG // NPjZUkZwCu1A+3b7syuwwzWzDzALBgNVHQ8EBAMCAYYw
// SIG // EAYJKwYBBAGCNxUBBAMCAQAwgZgGA1UdIwSBkDCBjYAU
// SIG // DqyCYEBWJ5flJRP8KuEKU5VZ5KShY6RhMF8xEzARBgoJ
// SIG // kiaJk/IsZAEZFgNjb20xGTAXBgoJkiaJk/IsZAEZFglt
// SIG // aWNyb3NvZnQxLTArBgNVBAMTJE1pY3Jvc29mdCBSb290
// SIG // IENlcnRpZmljYXRlIEF1dGhvcml0eYIQea0WoUqgpa1M
// SIG // c1j0BxMuZTBQBgNVHR8ESTBHMEWgQ6BBhj9odHRwOi8v
// SIG // Y3JsLm1pY3Jvc29mdC5jb20vcGtpL2NybC9wcm9kdWN0
// SIG // cy9taWNyb3NvZnRyb290Y2VydC5jcmwwVAYIKwYBBQUH
// SIG // AQEESDBGMEQGCCsGAQUFBzAChjhodHRwOi8vd3d3Lm1p
// SIG // Y3Jvc29mdC5jb20vcGtpL2NlcnRzL01pY3Jvc29mdFJv
// SIG // b3RDZXJ0LmNydDATBgNVHSUEDDAKBggrBgEFBQcDCDAN
// SIG // BgkqhkiG9w0BAQUFAAOCAgEAEJeKw1wDRDbd6bStd9vO
// SIG // eVFNAbEudHFbbQwTq86+e4+4LtQSooxtYrhXAstOIBNQ
// SIG // md16QOJXu69YmhzhHQGGrLt48ovQ7DsB7uK+jwoFyI1I
// SIG // 4vBTFd1Pq5Lk541q1YDB5pTyBi+FA+mRKiQicPv2/OR4
// SIG // mS4N9wficLwYTp2OawpylbihOZxnLcVRDupiXD8WmIsg
// SIG // P+IHGjL5zDFKdjE9K3ILyOpwPf+FChPfwgphjvDXuBfr
// SIG // Tot/xTUrXqO/67x9C0J71FNyIe4wyrt4ZVxbARcKFA7S
// SIG // 2hSY9Ty5ZlizLS/n+YWGzFFW6J1wlGysOUzU9nm/qhh6
// SIG // YinvopspNAZ3GmLJPR5tH4LwC8csu89Ds+X57H2146So
// SIG // dDW4TsVxIxImdgs8UoxxWkZDFLyzs7BNZ8ifQv+AeSGA
// SIG // nhUwZuhCEl4ayJ4iIdBD6Svpu/RIzCzU2DKATCYqSCRf
// SIG // WupW76bemZ3KOm+9gSd0BhHudiG/m4LBJ1S2sWo9iaF2
// SIG // YbRuoROmv6pH8BJv/YoybLL+31HIjCPJZr2dHYcSZAI9
// SIG // La9Zj7jkIeW1sMpjtHhUBdRBLlCslLCleKuzoJZ1GtmS
// SIG // hxN1Ii8yqAhuoFuMJb+g74TKIdbrHk/Jmu5J4PcBZW+J
// SIG // C33Iacjmbuqnl84xKf8OxVtc2E0bodj6L54/LlUWa8kT
// SIG // o/0wggd6MIIFYqADAgECAgphDpDSAAAAAAADMA0GCSqG
// SIG // SIb3DQEBCwUAMIGIMQswCQYDVQQGEwJVUzETMBEGA1UE
// SIG // CBMKV2FzaGluZ3RvbjEQMA4GA1UEBxMHUmVkbW9uZDEe
// SIG // MBwGA1UEChMVTWljcm9zb2Z0IENvcnBvcmF0aW9uMTIw
// SIG // MAYDVQQDEylNaWNyb3NvZnQgUm9vdCBDZXJ0aWZpY2F0
// SIG // ZSBBdXRob3JpdHkgMjAxMTAeFw0xMTA3MDgyMDU5MDla
// SIG // Fw0yNjA3MDgyMTA5MDlaMH4xCzAJBgNVBAYTAlVTMRMw
// SIG // EQYDVQQIEwpXYXNoaW5ndG9uMRAwDgYDVQQHEwdSZWRt
// SIG // b25kMR4wHAYDVQQKExVNaWNyb3NvZnQgQ29ycG9yYXRp
// SIG // b24xKDAmBgNVBAMTH01pY3Jvc29mdCBDb2RlIFNpZ25p
// SIG // bmcgUENBIDIwMTEwggIiMA0GCSqGSIb3DQEBAQUAA4IC
// SIG // DwAwggIKAoICAQCr8PpyEBwurdhuqoIQTTS68rZYIZ9C
// SIG // Gypr6VpQqrgGOBoESbp/wwwe3TdrxhLYC/A4wpkGsMg5
// SIG // 1QEUMULTiQ15ZId+lGAkbK+eSZzpaF7S35tTsgosw6/Z
// SIG // qSuuegmv15ZZymAaBelmdugyUiYSL+erCFDPs0S3XdjE
// SIG // LgN1q2jzy23zOlyhFvRGuuA4ZKxuZDV4pqBjDy3TQJP4
// SIG // 494HDdVceaVJKecNvqATd76UPe/74ytaEB9NViiienLg
// SIG // Ejq3SV7Y7e1DkYPZe7J7hhvZPrGMXeiJT4Qa8qEvWeSQ
// SIG // Oy2uM1jFtz7+MtOzAz2xsq+SOH7SnYAs9U5WkSE1JcM5
// SIG // bmR/U7qcD60ZI4TL9LoDho33X/DQUr+MlIe8wCF0JV8Y
// SIG // KLbMJyg4JZg5SjbPfLGSrhwjp6lm7GEfauEoSZ1fiOIl
// SIG // XdMhSz5SxLVXPyQD8NF6Wy/VI+NwXQ9RRnez+ADhvKwC
// SIG // gl/bwBWzvRvUVUvnOaEP6SNJvBi4RHxF5MHDcnrgcuck
// SIG // 379GmcXvwhxX24ON7E1JMKerjt/sW5+v/N2wZuLBl4F7
// SIG // 7dbtS+dJKacTKKanfWeA5opieF+yL4TXV5xcv3coKPHt
// SIG // bcMojyyPQDdPweGFRInECUzF1KVDL3SV9274eCBYLBNd
// SIG // YJWaPk8zhNqwiBfenk70lrC8RqBsmNLg1oiMCwIDAQAB
// SIG // o4IB7TCCAekwEAYJKwYBBAGCNxUBBAMCAQAwHQYDVR0O
// SIG // BBYEFEhuZOVQBdOCqhc3NyK1bajKdQKVMBkGCSsGAQQB
// SIG // gjcUAgQMHgoAUwB1AGIAQwBBMAsGA1UdDwQEAwIBhjAP
// SIG // BgNVHRMBAf8EBTADAQH/MB8GA1UdIwQYMBaAFHItOgIx
// SIG // kEO5FAVO4eqnxzHRI4k0MFoGA1UdHwRTMFEwT6BNoEuG
// SIG // SWh0dHA6Ly9jcmwubWljcm9zb2Z0LmNvbS9wa2kvY3Js
// SIG // L3Byb2R1Y3RzL01pY1Jvb0NlckF1dDIwMTFfMjAxMV8w
// SIG // M18yMi5jcmwwXgYIKwYBBQUHAQEEUjBQME4GCCsGAQUF
// SIG // BzAChkJodHRwOi8vd3d3Lm1pY3Jvc29mdC5jb20vcGtp
// SIG // L2NlcnRzL01pY1Jvb0NlckF1dDIwMTFfMjAxMV8wM18y
// SIG // Mi5jcnQwgZ8GA1UdIASBlzCBlDCBkQYJKwYBBAGCNy4D
// SIG // MIGDMD8GCCsGAQUFBwIBFjNodHRwOi8vd3d3Lm1pY3Jv
// SIG // c29mdC5jb20vcGtpb3BzL2RvY3MvcHJpbWFyeWNwcy5o
// SIG // dG0wQAYIKwYBBQUHAgIwNB4yIB0ATABlAGcAYQBsAF8A
// SIG // cABvAGwAaQBjAHkAXwBzAHQAYQB0AGUAbQBlAG4AdAAu
// SIG // IB0wDQYJKoZIhvcNAQELBQADggIBAGfyhqWY4FR5Gi7T
// SIG // 2HRnIpsLlhHhY5KZQpZ90nkMkMFlXy4sPvjDctFtg/6+
// SIG // P+gKyju/R6mj82nbY78iNaWXXWWEkH2LRlBV2AySfNIa
// SIG // SxzzPEKLUtCw/WvjPgcuKZvmPRul1LUdd5Q54ulkyUQ9
// SIG // eHoj8xN9ppB0g430yyYCRirCihC7pKkFDJvtaPpoLpWg
// SIG // Kj8qa1hJYx8JaW5amJbkg/TAj/NGK978O9C9Ne9uJa7l
// SIG // ryft0N3zDq+ZKJeYTQ49C/IIidYfwzIY4vDFLc5bnrRJ
// SIG // OQrGCsLGra7lstnbFYhRRVg4MnEnGn+x9Cf43iw6IGmY
// SIG // slmJaG5vp7d0w0AFBqYBKig+gj8TTWYLwLNN9eGPfxxv
// SIG // FX1Fp3blQCplo8NdUmKGwx1jNpeG39rz+PIWoZon4c2l
// SIG // l9DuXWNB41sHnIc+BncG0QaxdR8UvmFhtfDcxhsEvt9B
// SIG // xw4o7t5lL+yX9qFcltgA1qFGvVnzl6UJS0gQmYAf0AAp
// SIG // xbGbpT9Fdx41xtKiop96eiL6SJUfq/tHI4D1nvi/a7dL
// SIG // l+LrdXga7Oo3mXkYS//WsyNodeav+vyL6wuA6mk7r/ww
// SIG // 7QRMjt/fdW1jkT3RnVZOT7+AVyKheBEyIXrvQQqxP/uo
// SIG // zKRdwaGIm1dxVk5IRcBCyZt2WwqASGv9eZ/BvW1taslS
// SIG // cxMNelDNMYIEqjCCBKYCAQEwgZUwfjELMAkGA1UEBhMC
// SIG // VVMxEzARBgNVBAgTCldhc2hpbmd0b24xEDAOBgNVBAcT
// SIG // B1JlZG1vbmQxHjAcBgNVBAoTFU1pY3Jvc29mdCBDb3Jw
// SIG // b3JhdGlvbjEoMCYGA1UEAxMfTWljcm9zb2Z0IENvZGUg
// SIG // U2lnbmluZyBQQ0EgMjAxMQITMwAAAMMOm6fYstz3LAAA
// SIG // AAAAwzAJBgUrDgMCGgUAoIG+MBkGCSqGSIb3DQEJAzEM
// SIG // BgorBgEEAYI3AgEEMBwGCisGAQQBgjcCAQsxDjAMBgor
// SIG // BgEEAYI3AgEVMCMGCSqGSIb3DQEJBDEWBBRUN/lpWZj1
// SIG // RaCsaThy/nCcHyyKHjBeBgorBgEEAYI3AgEMMVAwTqAm
// SIG // gCQATQBpAGMAcgBvAHMAbwBmAHQAIABMAGUAYQByAG4A
// SIG // aQBuAGehJIAiaHR0cDovL3d3dy5taWNyb3NvZnQuY29t
// SIG // L2xlYXJuaW5nIDANBgkqhkiG9w0BAQEFAASCAQCkq4tO
// SIG // VjP6szFewnN6HfBMtifdiCwlB0MWCdzTT4mQTc/q+g9n
// SIG // p0xSerD1R+Zsfj1McAyQJJoMZWOYUyAZ3drZBKXbIhDW
// SIG // 0yqnYSEKIBd5LgLekWNIdNZMh2sGrdyNV2A7EzBSIGFv
// SIG // rZ7/XU5fPanS6/Ev/zIN1awatMV6XcU1e2wLEcNSqS/Y
// SIG // sBBkKffgy6EJym1GAvU87baXAOpQvT2U8CdqEJuBYWuw
// SIG // Jugwwi6t9qByoLe0RUmRP3dwY59+akgwcJC/1xQk2wSF
// SIG // z8EK+gQ3hOF29CYU159i7OV9U2qFw0yIxyQHI0Oaopty
// SIG // edbrdFlsk+P2cHHIfQ1QWP92HXTBoYICKDCCAiQGCSqG
// SIG // SIb3DQEJBjGCAhUwggIRAgEBMIGOMHcxCzAJBgNVBAYT
// SIG // AlVTMRMwEQYDVQQIEwpXYXNoaW5ndG9uMRAwDgYDVQQH
// SIG // EwdSZWRtb25kMR4wHAYDVQQKExVNaWNyb3NvZnQgQ29y
// SIG // cG9yYXRpb24xITAfBgNVBAMTGE1pY3Jvc29mdCBUaW1l
// SIG // LVN0YW1wIFBDQQITMwAAAMM7uBDWq3WchAAAAAAAwzAJ
// SIG // BgUrDgMCGgUAoF0wGAYJKoZIhvcNAQkDMQsGCSqGSIb3
// SIG // DQEHATAcBgkqhkiG9w0BCQUxDxcNMTcxMjI5MDYxMTM5
// SIG // WjAjBgkqhkiG9w0BCQQxFgQUBLBTVvXEYFjtO79voUQ1
// SIG // XbMDEkcwDQYJKoZIhvcNAQEFBQAEggEAHuAWzJageoEk
// SIG // 0jYOKUkWrGXUE7cvv8nvgO/OGXP3eq60yZE664dO4dQi
// SIG // D15oWNXE/x8eB1Y6GoUCePyKe7tpmzYJR2eKzuDqLgfF
// SIG // QvEAqJvncL3J833r0zvrL2qgVp7zWdNOgqW6LnqnCtH7
// SIG // yfUHJw3q2YWOt9Vk+EuqHYAbUuqN0P3Zu5cFasJPRC4T
// SIG // 2YZZDBNXdh27sBTb/NVFh8RGJ9QTL0/vQukAJBfZdS0M
// SIG // w2G2ZdW9SuaDhzGv2ZE+Q3zZCzufLnuGoVxyYZR3Asi0
// SIG // U8KnwDWIJSloJFWWU5OVJhd3Q2+qSt8XprM/DHIxcckT
// SIG // qh6XVE4IyFHNjUaKnH29yg==
// SIG // End signature block
