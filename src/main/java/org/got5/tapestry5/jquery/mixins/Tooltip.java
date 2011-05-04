package org.got5.tapestry5.jquery.mixins;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.jquery.ImportJQueryUI;
import org.got5.tapestry5.jquery.utils.JQueryUtils;

@ImportJQueryUI({ "jquery.ui.widget", "jquery.ui.core" })
@Import(library = { "${tapestry.jquery.path}/tooltip/jquery.ui.tooltip.js", "${tapestry.jquery.path}/mixins/tooltip.js" }, 
		stylesheet = { "${tapestry.jquery.path}/tooltip/jquery.ui.tooltip.css" })
public class Tooltip {
    /**
     * The field component to which this mixin is attached.
     */
    @InjectContainer
    private ClientElement element;

    @Environmental
    private JavaScriptSupport javaScriptSupport;

	@Parameter
    private JSONObject params;

    /**
     * Mixin afterRender phrase occurs after the component itself. This is where we write the
     * &lt;div&gt; element and
     * the JavaScript.
     *
     * @param writer
     */
    void afterRender(MarkupWriter writer)
    {
        String id = element.getClientId();

        JSONObject data = new JSONObject();
        data.put("id", id);
        
        javaScriptSupport.addInitializerCall("tooltip", data);
    }
}