def write_file_binary(file_path: str, to_write: str) -> None:
    """
    Writes given to_write string (should only consist of 0's and 1's) as bytes in the
    file
    """
    byte_length = 8
    try:
        with open(file_path, "wb") as opened_file:
            result_byte_array = [
                to_write[i : i + byte_length]
                for i in range(0, len(to_write), byte_length)
            ]

            if len(result_byte_array[-1]) % byte_length == 0:
                result_byte_array.append("10000000")
            else:
                result_byte_array[-1] += "1" + "0" * (
                    byte_length - len(result_byte_array[-1]) - 1
                )

            for elem in result_byte_array:
                opened_file.write(int(elem, 2).to_bytes(1, byteorder="big"))
    except OSError:
        print("File not accessible")
        sys.exit()


def compress(source_path, destination_path: str) -> None:
    """
    Reads source file, compresses it and writes the compressed result in destination
    file
    """
    data_bits = read_file_binary(source_path)
    compressed = compress_data(data_bits)
    compressed = add_file_length(source_path, compressed)
    write_file_binary(destination_path, compressed)


if __name__ == "__main__":
    compress(sys.argv[1], sys.argv[2])
