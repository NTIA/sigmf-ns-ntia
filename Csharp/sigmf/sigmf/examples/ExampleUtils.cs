using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;

namespace sigmf.examples
{
    public class ExampleUtils
    {
        public static DateTime dateFormat = new DateTime();

        public static List<Capture> getCaptures(DateTime date)
        {
            List<Capture> captures = new List<Capture>();
            Capture capture = new Capture();
            capture.SampleStart = 0;
            capture.DateTime = date;
            capture.Frequency = 700000000;
            captures.Add(capture);
            return captures;
        }
        public static Globals getGlobals(DateTime date) {
            Globals globals = new Globals();
            var rand = new Random();
            globals.TaskId = ((long)(rand.NextDouble() * 1000000));
            globals.Datatype = "rf32_le";
            globals.SampleRate = 15360000;
            //var c = Calendar.CurrentEra;
            return globals;
        
        }
        private Sensor getSensor(string id)
        {
            Sensor sensor = new Sensor();
            sensor.Id = id;
            sensor.Antenna = getAntenna();
            return sensor;

        }
        public static Antenna getAntenna() {
            Antenna antenna = new Antenna();
            HardwareSpec spec = new HardwareSpec();
            spec.Model = "model xyz";
            antenna.AntennaSpec = spec;
            return antenna;
        }
        private Action getAction()
        {
            Action action = new Action();
            action.Name = "M4";
            return action;
        }
    }
}
