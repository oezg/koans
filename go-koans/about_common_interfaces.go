package go_koans

import (
	"bytes"
)

func aboutCommonInterfaces() {
	{
		in := new(bytes.Buffer)
		in.WriteString("hello world")

		out := new(bytes.Buffer)

		/*
		   Your code goes here.
		   Hint, use these resources:

		   $ godoc -http=:8080
		   $ open http://localhostsudo:8080/pkg/io/
		   $ open http://localhost:8080/pkg/bytes/
		*/

		out.ReadFrom(in)
		assert(out.String() == "hello world") // get data from the io.Reader to the io.Writer
	}

	{
		in := new(bytes.Buffer)
		in.WriteString("hello world")

		out := new(bytes.Buffer)

		x, _ := in.ReadBytes('o')
		out.Write(x)
		assert(out.String() == "hello") // duplicate only a portion of the io.Reader
	}
}
