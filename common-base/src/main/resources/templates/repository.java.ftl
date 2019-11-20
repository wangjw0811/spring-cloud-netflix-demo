package ${package.Repository};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.repositoryName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.repositoryName} extends ${superServiceClass}<${entity}> {

}
</#if>
