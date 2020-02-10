using AutoMapper;
using Newtonsoft.Json;
using Newtonsoft.Json.Schema;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using NJsonSchema;
using NJsonSchema.Converters;
using System.Runtime.Serialization.Json;

namespace sigmf
{
    public static class SchemaGenerator
    {
        public static void Main(string[] args) {

            //TODO
            //JsonConvert.SerializeObject();
            var schema = NJsonSchema.JsonSchema.FromType<MetaDoc>();
            var schemaJson = schema.ToJson();
            //JsonConvert.SerializeObject(new FileInfo("sigmf-ns-ntia.schema"), schema);
            var generatedschema = JsonConvert.DeserializeObject<MetaDoc>(schemaJson);
            Console.WriteLine(generatedschema);
            Console.ReadLine();
        }
    }
}
